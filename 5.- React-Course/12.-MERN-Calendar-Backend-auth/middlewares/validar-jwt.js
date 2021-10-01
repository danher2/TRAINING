//otro middleware

//VALIDA EL JSON WEB TOKEN EN CADA SERVICIO CADA 2 HRS


const { response } = require('express');
const jwt = require('jsonwebtoken');


const validarJWT = ( req, res = response, next ) => {

    // x-token headers, mando mi token en  header
    const token = req.header('x-token'); // -> header que necesito leer el x-token


    //ahora a validar el token
    if ( !token ) { // si token no tiene nada, null o undefined
        return res.status(401).json({ // status no autenticado
            ok: false, // false
            msg: 'No hay token en la petición' // no hay token
        });
    }

    try { // solo se dispara si la validacion del token fall
        
        const { uid, name } = jwt.verify( // desestructuramos uid y name del payload
            token, // pide el token
            process.env.SECRET_JWT_SEED // y el secret public key que es la firma de los tokens debe estar bien protegido y oculto
        );

        // se puede modificar el request y esta informacion sera pasado a las funciones que vengan despues de esta validacion
        req.uid = uid;
        req.name = name;


    } catch (error) {
        return res.status(401).json({ // unauthorized
            ok: false,
            msg: 'Token no válido'
        });
    }



    next();  // si todo esta correcto, llame lo que sigue
}


module.exports = {
    validarJWT
}
