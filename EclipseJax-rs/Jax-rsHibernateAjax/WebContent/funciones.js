var xmlhttp
function PacienteConsultaAll(nombres)
{

    xmlhttp = GetXmlHttpObject();
    if (xmlhttp == null)
    {
        alert("Tu navegador no soporta AJAX");
        return;
    }
    alert("aden");
    var url = "consultarPaciente";
    url = url + "?nombres=" + nombres;
    xmlhttp.onreadystatechange = getOutput1;
    xmlhttp.open("GET", url, true);
    xmlhttp.send(null);
}
function InsertarCliente(rut, nombre, descuento) {
	alert("adentro js");
    xmlhttp = GetXmlHttpObject();
    if (xmlhttp == null)
    {
        alert("Tu navegador no soporta AJAX");
        return;
    }
    var url = "tipoClienteController";
    url = url + "?idTipo=" + rut+ "&nombres="+nombre+ "&descuento="+descuento;
    xmlhttp.onreadystatechange = getOutput2;
    xmlhttp.open("GET", url, true);
    xmlhttp.send(null);
}
function getOutput1()
{

    if (xmlhttp.readyState == 4)
    {
        var f = xmlhttp.responseText;
        var tipo = f.split("<br>");
        var table = document.getElementById("tableClient");

// Create an empty <tr> element and add it to the 1st position of the table:
        var row = [tipo.length - 1];
        for (var i = 1; i <= tipo.length - 1; i = i + 2) {

            row[i] = table.insertRow(0);
            row[i].insertCell(0).innerHTML = tipo[i - 1];
            row[i].insertCell(1).innerHTML = tipo[i];

        }
        //document.getElementById("divParcial").innerHTML = xmlhttp.responseText;
    }
}


function getOutput2()
{

    if (xmlhttp.readyState == 4)
    {
  
        document.getElementById("divParcial").innerHTML = xmlhttp.responseText;
    }

}

function GetXmlHttpObject()
{
    if (window.XMLHttpRequest)
    {
        return new XMLHttpRequest();
    }
    if (window.ActiveXObject)
    {
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
    return null;
}
