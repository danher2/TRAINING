const { response } = require('express');
const bcrypt = require('bcryptjs');
const Usuario = require('../models/Usuario'); // del modelo usuario para crear  usuario
const { generarJWT } = require('../helpers/jwt'); // importamor el generador de tokens, una funcion promesa
 


// metodo crear usuario de mi controlador
const crearUsuario = async(req, res = response ) => {

    const { email, password } = req.body; // se le manda email y password en el body


    // siempre manejar las peticiones con try y catch ,por si sale algun error
    try {

        // verificar si el email existe en la base de datos
        let usuario = await Usuario.findOne({ email }); // findone= promesa, hace una peticion al servidor  para encontrar si ya existe email

        if ( usuario ) { // si existe el usuario, significaria que le debo enviar un error a mi usuario
            return res.status(400).json({ // devuelva un bad request
                ok: false, // respuesta falso
                msg: 'El usuario ya existe' // mensaje
            });
        }

        // si no existe el usuario entonces se puede registras entonces...
        usuario = new Usuario( req.body ); // se manda el usuario al body del request
    
        // Encriptar contraseña
        const salt = bcrypt.genSaltSync(); // encriptacion
        usuario.password = bcrypt.hashSync( password, salt ); //se encripta la pass


        await usuario.save(); // se guarda el usuario en la db, es una promesa que se espera a que se resuelva con el await

        // Generar JWT
        const token = await generarJWT( usuario.id, usuario.name ); // promesa que puedo esperarla con el await
    
        res.status(201).json({ // 201 se registro correctamente
            ok: true,
            uid: usuario.id,
            name: usuario.name,
            token
        })
        
    } catch (error) {
        console.log(error)
        res.status(500).json({
            ok: false,
            msg: 'Por favor hable con el administrador'
        });
    }
}


//Login usuario

const loginUsuario = async(req, res = response ) => {

    //confirmar si existe ese usuario 
    const { email, password } = req.body;

    try {
        
        const usuario = await Usuario.findOne({ email });

        if ( !usuario ) {
            return res.status(400).json({ //bad request
                ok: false,
                msg: 'El usuario no existe con ese email'
            });
        }

        // 2do. paso es -> Confirmar los passwords
        const validPassword = bcrypt.compareSync( password, usuario.password ); //boleano que compara la passwrod recibida contra la password de la db

        if ( !validPassword ) { // si valid es false. contrasena no coincide
            return res.status(400).json({ // bad request
                ok: false,
                msg: 'Password incorrecto'
            });
        }

        // Generar JWT // devuelve un objeto con  un token
        const token = await generarJWT( usuario.id, usuario.name );  // es una promesa, podemos esperarla con el await

        res.json({
            ok: true,
            uid: usuario.id,
            name: usuario.name,
            token
        })


    } catch (error) {
        console.log(error);
        res.status(500).json({
            ok: false,
            msg: 'Por favor hable con el administrador'
        });
    }

}


const revalidarToken = async (req, res = response ) => {

    // desestructuramos la uid y el name de req
    const { uid, name } = req;

    // Generar JWT  generamos un nuevo token
    const token = await generarJWT( uid, name );


    // se retorna el nuevo token
    res.json({
        ok: true,
        token
    })
}




module.exports = {
    crearUsuario,
    loginUsuario,
    revalidarToken
}