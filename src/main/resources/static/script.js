import { drinkItem } from "./drinkItem.js";

function displayItems(){
    var coffee = document.getElementById('coffee');
    var tea = document.getElementById('tea');
    var non = document.getElementById('non');
    var bakery = document.getElementById('bakery');

    const coffeeData = drinkItem.filter(item=> item.category=='coffee');
    const teaData = drinkItem.filter(item=> item.category=='tea');
    const nonData = drinkItem.filter(item=> item.category=='non');
    const bakeryData = drinkItem.filter(item=> item.category=='bakery');

    coffeeData.map(item=> {
        var itemCard = document.createElement('div');
        itemCard.setAttribute('id' , 'item-card');

        var cardTop = document.createElement('div');
        cardTop.setAttribute('id' , 'card-top');

        var cart = document.createElement('i');
        cart.setAttribute('class' , 'fa fa-shopping-cart add-to-cart');
        cart.setAttribute('id' , item.id);

        cardTop.appendChild(cart);

        var img = document.createElement('img');
        img.src= item.img;

        var itemName = document.createElement('p');
        itemName.setAttribute('id' , 'item-name');
        itemName.innerText = item.name;

        var itemPrice = document.createElement('p');
        itemPrice.setAttribute('id' , 'item-price');
        itemPrice.innerText = 'Price : ' + item.price + ' Bath';

        itemCard.appendChild(cardTop);
        itemCard.appendChild(img);
        itemCard.appendChild(itemName);
        itemCard.appendChild(itemPrice);

        coffee.appendChild(itemCard);
    })

    teaData.map(item=> {
        var itemCard = document.createElement('div');
        itemCard.setAttribute('id' , 'item-card');

        var cardTop = document.createElement('div');
        cardTop.setAttribute('id' , 'card-top');

        var cart = document.createElement('i');
        cart.setAttribute('class' , 'fa fa-shopping-cart add-to-cart');
        cart.setAttribute('id' , item.id);

        cardTop.appendChild(cart);

        var img = document.createElement('img');
        img.src= item.img;

        var itemName = document.createElement('p');
        itemName.setAttribute('id' , 'item-name');
        itemName.innerText = item.name;

        var itemPrice = document.createElement('p');
        itemPrice.setAttribute('id' , 'item-price');
        itemPrice.innerText = 'Price : ' + item.price + ' Bath';

        itemCard.appendChild(cardTop);
        itemCard.appendChild(img);
        itemCard.appendChild(itemName);
        itemCard.appendChild(itemPrice);

        tea.appendChild(itemCard);
    })

    nonData.map(item=> {
        var itemCard = document.createElement('div');
        itemCard.setAttribute('id' , 'item-card');

        var cardTop = document.createElement('div');
        cardTop.setAttribute('id' , 'card-top');

        var cart = document.createElement('i');
        cart.setAttribute('class' , 'fa fa-shopping-cart add-to-cart');
        cart.setAttribute('id' , item.id);

        cardTop.appendChild(cart);

        var img = document.createElement('img');
        img.src= item.img;

        var itemName = document.createElement('p');
        itemName.setAttribute('id' , 'item-name');
        itemName.innerText = item.name;

        var itemPrice = document.createElement('p');
        itemPrice.setAttribute('id' , 'item-price');
        itemPrice.innerText = 'Price : ' + item.price + ' Bath';

        itemCard.appendChild(cardTop);
        itemCard.appendChild(img);
        itemCard.appendChild(itemName);
        itemCard.appendChild(itemPrice);

        non.appendChild(itemCard);
    })

    bakeryData.map(item=> {
        var itemCard = document.createElement('div');
        itemCard.setAttribute('id' , 'item-card');

        var cardTop = document.createElement('div');
        cardTop.setAttribute('id' , 'card-top');

        var cart = document.createElement('i');
        cart.setAttribute('class' , 'fa fa-shopping-cart add-to-cart');
        cart.setAttribute('id' , item.id);

        cardTop.appendChild(cart);

        var img = document.createElement('img');
        img.src= item.img;

        var itemName = document.createElement('p');
        itemName.setAttribute('id' , 'item-name');
        itemName.innerText = item.name;

        var itemPrice = document.createElement('p');
        itemPrice.setAttribute('id' , 'item-price');
        itemPrice.innerText = 'Price : ' + item.price + ' Bath';

        itemCard.appendChild(cardTop);
        itemCard.appendChild(img);
        itemCard.appendChild(itemName);
        itemCard.appendChild(itemPrice);

        bakery.appendChild(itemCard);
    })
}
displayItems();

const categoryListData = [...new Map(drinkItem.map(item=> [item['category'],item])).values()];

function categoryList(){
    var categoryList = document.getElementById('category-list');

    categoryListData.map(item=>{
        var listCard = document.createElement('div');
        listCard.setAttribute('class' , 'list-card');

        var listName = document.createElement('a');
        listName.setAttribute('class' , 'list-name');
        listName.innerText = item.category;
        listName.setAttribute('href' , '#' + item.category);

        listCard.appendChild(listName);

        var cloneListCard = listCard.cloneNode(true);
        categoryList.appendChild(listCard);
        document.querySelector('.category-header').appendChild(cloneListCard);
    })
}
categoryList();

document.querySelectorAll('.add-to-cart').forEach(item=>{
    item.addEventListener('click' , addToCart);
})

var cartData= [];
function addToCart(){

    var itemToAdd = this.parentNode.nextSibling.nextSibling.innerText;
    var itemObj = drinkItem.find(element=>element.name==itemToAdd);
    console.log(itemObj);
    
    var index = cartData.indexOf(itemObj);
    if(index=== -1){
        document.getElementById(itemObj.id).classList.add('toggle-cart');
        cartData = [...cartData,itemObj];        
    }
    else if(index > -1){
        alert("Already added to cart!!!");
    }

    document.getElementById('cart-plus').innerText = '  ' + cartData.length + ' Items';
    document.getElementById('m-cart-plus').innerText = '  ' + cartData.length;
    totalAmount();
    cartItems();

}

function cartItems(){
    var tableBody=  document.getElementById('table-body');
    tableBody.innerHTML= '';

    cartData.map(item=> {
        var tableRow= document.createElement('tr');
        
        var rowData1= document.createElement('td');
        var img= document.createElement('img');
        img.src= item.img;
        rowData1.appendChild(img);
    
        var rowData2= document.createElement('td');
        rowData2.innerText= item.name;
        
        var rowData3= document.createElement('td');
        var btn1= document.createElement('button');
        btn1.setAttribute('class','decrease-item');
        btn1.innerText= '-';
        var span= document.createElement('span');
        span.innerText= item.quantity;
        var btn2= document.createElement('button');
        btn2.setAttribute('class','increase-item');
        btn2.innerText= '+';
        
        rowData3.appendChild(btn1);
        rowData3.appendChild(span);
        rowData3.appendChild(btn2);
    
        var rowData4= document.createElement('td');
        rowData4.innerText= item.price + ' Bath';
    
        tableRow.appendChild(rowData1);
        tableRow.appendChild(rowData2);
        tableRow.appendChild(rowData3);
        tableRow.appendChild(rowData4);
    
        tableBody.appendChild(tableRow);
    })
    document.querySelectorAll('.increase-item').forEach(item=>{
        item.addEventListener('click',incrementItem)
    })

    document.querySelectorAll('.decrease-item').forEach(item=>{
        item.addEventListener('click',decrementItem)
    })
}


function incrementItem(){
    let itemToInc = this.parentNode.previousSibling.innerText;
    console.log(itemToInc);

    var incObj =cartData.find(element=>element.name== itemToInc);
    incObj.quantity+=1;

    currPrice = (incObj.price*incObj.quantity - incObj.price*(incObj.quantity-1))/(incObj.quantity-1);

    incObj.price = currPrice*incObj.quantity;
    totalAmount()
    cartItems();
}

var currPrice=0;

function decrementItem(){
    let itemToDec = this.parentNode.previousSibling.innerText;
    let decObj = cartData.find(element=>element.name== itemToDec);
    let ind = cartData.indexOf(decObj);
    if(decObj.quantity > 1){
        currPrice = (decObj.price*decObj.quantity - decObj.price*(decObj.quantity-1))/(decObj.quantity);   
        decObj.quantity-=1;
        decObj.price= currPrice*decObj.quantity;    
    }
    else {
        document.getElementById(decObj.id).classList.remove('toggle-cart');
        cartData.splice(ind,1);
        document.getElementById('cart-plus').innerHTML = ' ' + cartData.length + ' Items';
        document.getElementById('m-cart-plus').innerHTML = ' ' + cartData.length;
    
        if(cartData.length < 1 && flag){
            document.getElementById('drink-items').classList.toggle('drink-items');
            document.getElementById('category-list').classList.toggle('drink-items');
            document.getElementById('m-cart-plus').classList.toggle('m-cart-toggle');
            document.getElementById('cart-page').classList.toggle('cart-toggle');
            document.getElementById('category-header').classList.toggle('toggle-category');
            document.getElementById('checkout').classList.toggle('cart-toggle');
            flag = false;
            alert("Currently no item in cart");
            console.log(flag)
        }
    }
    totalAmount()
    cartItems()

}

function totalAmount(){
    var sum=0;
    cartData.map(item=>{
        sum+= item.price;
    })
    document.getElementById('total-item').innerText = 'Total Item : ' + cartData.length;
    document.getElementById('total-price').innerText = 'Total Price : ' + sum + ' Bath';
    document.getElementById('m-total-amount').innerText= 'Total Price : ' + sum + ' Bath';
}

document.getElementById('cart-plus').addEventListener('click' , cartToggle);
document.getElementById('m-cart-plus').addEventListener('click' , cartToggle);

var flag = false;

function cartToggle(){
    if(cartData.length > 0){
        document.getElementById('drink-items').classList.toggle('drink-items');
        document.getElementById('category-list').classList.toggle('drink-items');
        document.getElementById('m-cart-plus').classList.toggle('m-cart-toggle');
        document.getElementById('cart-page').classList.toggle('cart-toggle');
        document.getElementById('category-header').classList.toggle('toggle-category');
        document.getElementById('checkout').classList.toggle('cart-toggle');
        flag=true;
    }
    else {
        alert("Currently no items in cart");
    }
}

window.onresize= window.onload= function(){
    var size = window.innerWidth;
    console.log(size)
    if(size<800){
        var cloneDrinkItems = document.getElementById('drink-items').cloneNode(true);
        var cloneCartPage = document.getElementById('cart-page').cloneNode(true);
        document.getElementById('drink-items').remove();
        document.getElementById('cart-page').remove();
        document.getElementById('category-header').after(cloneDrinkItems);
        document.getElementById('drink-items').after(cloneCartPage);
        addEvents()
    }
    if(size>800){
        var cloneDrinkItems = document.getElementById('drink-items').cloneNode(true);
        document.getElementById('drink-items').remove();
        document.getElementById('header').after(cloneDrinkItems);

        var cloneCartPage = document.getElementById('cart-page').cloneNode(true);
        document.getElementById('cart-page').remove();
        document.getElementById('drink-items').after(cloneCartPage);
        addEvents()
    }
}

function addEvents(){
    document.querySelectorAll('.add-to-cart').forEach(item=>{
        item.addEventListener('click',addToCart)
    })
    document.querySelectorAll('.increase-item').forEach(item=>{
        item.addEventListener('click',incrementItem)
    })

    document.querySelectorAll('.decrease-item').forEach(item=>{
        item.addEventListener('click',decrementItem)
    })
}

