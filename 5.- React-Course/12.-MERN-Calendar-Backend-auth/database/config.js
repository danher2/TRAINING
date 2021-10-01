//TODA LA CONFIGURACION NECESARIA PARA CONECTARSE A LA BASE DE DATSO

const mongoose = require('mongoose');


const dbConnection = async() => {//devuelve una promesa por eso ponemos async, metodo connect
    try {
        

        //configuracion de mongoose
        await mongoose.connect( process.env.DB_CNN , {
            useNewUrlParser: true, 
            useUnifiedTopology: true,
            useCreateIndex: true
        });

        console.log('DB Online');


    } catch (error) {
        console.log(error);
        throw new Error('Error a la hora de inicializar BD');
    }


}

//exportamos nuestra configuracion
module.exports = {
    dbConnection
}