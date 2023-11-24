function confirmOrders (){
    document.getElementById('confirm-btn').addEventListener('click' , removeItem);

}
confirmOrders();

function removeItem() {
    var elementToDelete = document.getElementById('drink-receipt');
    elementToDelete.remove();
    
}