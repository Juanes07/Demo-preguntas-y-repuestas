# Entrega de reto - Aplicaciones Empresariales - Ciclo 2
# Proyecto realizado con spring boot y angular
#  Caracteristicas logradas:
-	Consumo del back-end.
-	Rutas internas y externas
-	Login de usuario y contraseña
-	Autentificación con Gmail
-	Reestablecer contraseña
-	Uso de observable angular
-	Uso de frameworks CSS
-	Paginador de 10 preguntas
-	Documentacion de la Api usando swagger
-	Usuario puede agregar preguntas y aparecen en la pagina home 
-	Despliegue con heroku y firebase
-	Pruebas en fronted realizas con librería cypress
-	Pruebas reactivas en backend
-	Scroll infinito de respuestas (Las respuestas no se lograron filtrar por pregunta, se enlistan todas las respuesta de la base de datos)

# Link de Deploys

Link swagger (Recordatorio de que swagger es a nivel local, se debe levantar el backend primero antes de acceder a este link):  http://localhost:8080/swagger-ui.html
![imagen](https://user-images.githubusercontent.com/96356792/173254362-f50b2fcc-d7d4-4ea2-b82e-f21506c4f9f4.png)


Link Deploy Frontend:  https://demopreguntas-c2b95.web.app/preguntas
![imagen](https://user-images.githubusercontent.com/96356792/173254324-12b9f561-bbc1-4993-bf97-44a8eb753e2f.png)

Link Deploy Backend: https://reto-preguntas.herokuapp.com/heroku/deploy
![imagen](https://user-images.githubusercontent.com/96356792/173254349-1369b55f-30ca-4c2f-8851-742555319a85.png)


#  Validacion de pruebas Angular:

Se debe Ejecutar el siguiente comando para descargar la librería cypress

 npm install –-save -D cypress 
 
Una vez instalada para correr el servidor de pruebas se hace el siguiente comando

  npx cypress open
  
esperamos un momento y se abrirá la siguiente ventana 

![cypress1](https://user-images.githubusercontent.com/96356792/173254165-26ad6bf1-5123-490e-8f10-e4ec6c0db8e8.png)


se hace click en el recuadro marcado en la imagen


![cypress2](https://user-images.githubusercontent.com/96356792/173254167-e016e0e8-2e74-456d-96ab-840491662bcd.png)

seleccionamos el navegador que deseemos y hacemos click en ´´start testing´´


![cypress3](https://user-images.githubusercontent.com/96356792/173254170-a004e507-e18b-4a3f-8447-752d4409f20d.png)

se nos carga en el navegador previamente seleccionado el dashboard de cypres. 
En el cual al hacer click a cualquiera de las pruebas se nos inicializa el test correspondiente.

![cypress4](https://user-images.githubusercontent.com/96356792/173254174-eaa56c22-d6ba-46d0-a5da-c61f78ff41e5.png)

![imagen5](https://user-images.githubusercontent.com/96356792/173254178-3d90b67a-5676-4210-b0c3-aae88746a790.png)

![imagen6](https://user-images.githubusercontent.com/96356792/173254180-d5cf81e3-b5b7-45ab-9d92-f40c28b1ce5c.png)

# Prueba Postman 

#### Guardar Pregunta 🟢

![guardarPregunta](https://user-images.githubusercontent.com/96356792/173972575-567310ab-1faf-43d9-a3ae-280b58f93bf3.png)

#### Listar Pregunta 🟢

![listarPreguntas](https://user-images.githubusercontent.com/96356792/173972602-c9659dc3-7ae4-47a7-b02d-e96d1fea9b06.png)

#### Obtener Pregunta por ID 🟡

![obtenerPreguntaId](https://user-images.githubusercontent.com/96356792/173972676-d784f267-33fd-4c7a-b6b2-069261d0f362.png)

#### Eliminar Pregunta 🔴
![eliminarPregunta](https://user-images.githubusercontent.com/96356792/173972711-4d533f3a-1faa-4c60-acf6-c458aa588f29.png)

#### Guadar Respuesta 🟢
![guardarRespuesta](https://user-images.githubusercontent.com/96356792/173972842-9a4e3630-fd25-4b40-8ae9-0a8563ace2dc.png)

#### Listar Respuestas 🟢
![listarRespuestas](https://user-images.githubusercontent.com/96356792/173972873-fecb9148-a8da-4479-ab05-1a7be266f4b1.png)

#### Obtener Respuesta por ID 🟡
![obtenerRespuestaId](https://user-images.githubusercontent.com/96356792/173972903-f9370d9a-3b65-4179-bf07-ab91dd250e4f.png)

#### Eliminar Respuesta 🔴
![eliminarRespuesta](https://user-images.githubusercontent.com/96356792/173973113-770d5030-07ab-43a2-88f1-ee0883cf4e7c.png)



