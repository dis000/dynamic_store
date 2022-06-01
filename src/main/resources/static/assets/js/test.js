

const feedDisplay = document.querySelector('#feed')

fetch('http://localhost:8080/category')
    .then(response => response.text())
    .then(data => {
        data.forEach(categoryDto => {
            const articleItem = categoryDto.title;

            return articleItem;
        })
        })
    .catch(err => console.log(err))

