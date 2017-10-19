<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html; charset=UTF-8" http-equiv="content-type">
        <title></title>
    </head>
    <body>
        <h1>Nuevo Contexto
             <%
                        if (request.getAttribute("resultado") != null) {
                            Boolean resultado = (Boolean) request.getAttribute("resultado");
                            if (resultado.booleanValue() == true) {
                    %>
                    <h2> se ha registrado de manera exitosa</h2>
                    <%
                    } else {
                    %>     
                    <h2> llene los campos correctamente </h2>
                    <%
                            }
                        }
                    %>
                    
            
            <p>Ingrese la informacion solicitada</p>

            <form action="InsertarContexto" method="post">
                <div class="form_settings">
                    <p><span>Numero De Contexto</span>
                        <input class="contact" type="text" name="id_contexto" value="" /></p>
                    <p><span>Numero De Modelo</span>
                        <input class="contact" type="text" name="id_modelo" value="" /></p>
                    <p><span>Link</span>
                        <input class="contact" type="text" name="link" value="" /></p>
                    <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="submit" /></p>
                </div>

                
                
                                     
            </form>
            <p><br>
            </p>
        </h1>
    </body>
</html>
