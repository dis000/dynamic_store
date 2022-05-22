const feedDisplay = document.querySelector('#feed')

fetch('http://localhost:8080/category')
    .then(response => response.json())
    .then(data => {
        data.forEach(categoryDto => {
            const articleItem = '<div><h3>' + categoryDto.title + '</h3><p>' + categoryDto.url +'</p></div>'
            feedDisplay.insertAdjacentHTML("beforeend", articleItem)
        })
        })
    .catch(err => console.log(err))