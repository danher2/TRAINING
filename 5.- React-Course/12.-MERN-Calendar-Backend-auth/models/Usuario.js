const { Schema, model } = require('mongoose');


//Modelo, entity, pojos etc


const UsuarioSchema = Schema({   // objeto con la configuracion que necesito, es como las tablas que haces en spring
    name: {
        type: String,
        require: true //. nombre requerido
    },
    email: {
        type: String,
        require: true,
        unique: true   // email unico
    },
    password: {
        type: String,
        require: true  // password requerida tambien
    }
});

// exportamos nuestro modelo para usarlo en el controlador
module.exports = model('Usuario', UsuarioSchema );

