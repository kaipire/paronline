function aviso_historial(u)
{ 
    if(u == null || u.getCedula() == 12345 ){
        alert("Debe loguearse para revisar su historial de compras");
    }
}

function aviso_carrito()
{ 
    alert("Debe loguearse para poder realizar la comprar");
}


