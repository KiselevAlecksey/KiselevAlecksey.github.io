<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Текстовый процессор</title>
</head>
<body>
<h1>Введите текст для обработки</h1>
<textarea id="textInput" rows="10" cols="50" placeholder="Введите текст здесь..."></textarea>
<br>

<label for="cutoffInput">Введите cutoff:</label>
<input type="text" id="cutoffInput" placeholder="Введите cutoff (3-12 символов)" required>
<br>

<label for="regexInput">Введите regex:</label>
<input type="text" id="regexInput" placeholder="Введите regex (минимум 2 символа)">
<br>

<button id="submitButton">Отправить</button>

<h2>Результат:</h2>
<pre id="resultOutput"></pre>

<script>
    document.getElementById('submitButton').addEventListener('click', function() {
        const text = document.getElementById('textInput').value;
        const cutoff = document.getElementById('cutoffInput').value;
        const regex = document.getElementById('regexInput').value;

        fetch('http://localhost:8080/api/process-text', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ text: text, cutoff: cutoff, regex: regex })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Сетевая ошибка');
            }
            return response.json();
        })
        .then(data => {
            // Обработка результата
            const formattedText = data.text.join('\n');
            document.getElementById('resultOutput').textContent = formattedText;
        })
        .catch(error => {
            console.error('Ошибка:', error);
            document.getElementById('resultOutput').textContent = 'Произошла ошибка при обработке.';
        });
    });
</script>
</body>
</html>
