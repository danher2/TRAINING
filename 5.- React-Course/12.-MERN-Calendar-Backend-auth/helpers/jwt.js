

//FUNCION ENCARGADA DE GENERAR MI JSON WEB TOKEN  con la libreria npm i jsonwebtoken

const jwt = require('jsonwebtoken');


// libraria no trabaja en base a promesas sino en base a callbacks
const generarJWT = ( uid, name ) => {



    // aqui creamos la promesa
    return new Promise( (resolve, reject) => {

        //todo el proceso de la generaxcion del json webtoken

        //creacion del payload
        const payload = { uid, name };

        //generar el token, sign para firmar el token 
        jwt.sign( payload, process.env.SECRET_JWT_SEED, {
            expiresIn: '2h' // token expira en 2horas
        }, (err, token ) => { // un error en caso que no se pueda generar el token por alguna razon

            if ( err ){
                console.log(err);
                reject('No se pudo generar el token');
            }

            resolve( token );// si todo se hace correctamento, resolvemos con este resolve el token

        })


    })
}



// exportamos nuestra funcion para generar el token
module.exports = {
    generarJWT
}


