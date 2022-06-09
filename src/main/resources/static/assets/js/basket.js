function addItemToBasket(id) {
    var basket = Cookies.get('basket');
    if (typeof basket == 'undefined') {
        var changedBasket = [id]
        Cookies.set('basket', changedBasket)
    }
    else {
        var array = JSON.parse("[" + basket + "]");
        array.push(id);
        Cookies.set('basket', array)
    }

}

function removeItemFromBasket(id) {
    var basket = Cookies.get('basket');
    var changedBasket = JSON.parse("[" + basket + "]");
    var element = changedBasket.indexOf(id);
    changedBasket.splice(element, 1);
    Cookies.set('basket', changedBasket);
}