const express = require('express');
require('dotenv').config();
const cors = require('cors'); // es para restringir peticiones , capa de seguridad para anadir a la api solo puede ser a ciertas rutas
const { dbConnection } = require('./database/config');

// Crear el servidor de express
const app = express();

// Base de datos , funcion importada de config.js
dbConnection();

// CORS
app.use(cors())

// Directorio Público , funcion que se ejecuta cuando alguien hace una peticion (MIDDLEWARE)
app.use( express.static('public') ); // public por la carpeta public

// Lectura y parseo del body
app.use( express.json() );

// Rutas
app.use('/api/auth', require('./routes/auth') );
// TODO: CRUD: Eventos



// Escuchar peticiones
app.listen( process.env.PORT, () => {
    console.log(`Servidor corriendo en puerto ${ process.env.PORT }`);
});






