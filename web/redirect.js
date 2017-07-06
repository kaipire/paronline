function ir_a_inicio(){
    location.href="/paronline/index.jsp";
}    

function ir_a_login(){
    location.href="/paronline/Login.jsp";
}

function ir_a_reg_prod(){
    location.href="/paronline/ProductoNuevo.jsp";
}    

function ir_a_reg_cat(){
    location.href="/paronline/CategoriaProductoNuevo.jsp";
}

function ir_a_list_cli(){
    location.href="/paronline/ClienteServlet";
}

function ir_a_list_cat(){
    location.href="/paronline/CategoriaProductoServlet";
}

function ir_a_list_prod(){
    location.href="/paronline/ProductoServlet";
} 
function ir_a_admin(){
    location.href="/paronline/indexAdmin.jsp";
}
function habilita(value)
{ 
    document.getElementById("num_tarjeta").disabled=false;
}

function deshabilita(value)
{ 
    document.getElementById("num_tarjeta").disabled=true;
}

