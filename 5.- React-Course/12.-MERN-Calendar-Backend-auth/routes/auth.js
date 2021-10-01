/*
    Rutas de Usuarios / Auth
    host + /api/auth
*/
//sacamos o extraemos las funciones de las carpetas del proyecto y node
const { Router } = require('express');
const { check } = require('express-validator'); // cheack valida los campos y se extrare de express-validator
const { validarCampos } = require('../middlewares/validar-campos'); // aqui se en cuentran nuestras validaciones
const { crearUsuario, loginUsuario, revalidarToken } = require('../controllers/auth');
const { validarJWT } = require('../middlewares/validar-jwt');// mandamos al renew el validar jsotoken


const router = Router();

//SIEMPRE EN CADA SERVICIO ANTES DE TODO SE REVALIDA EL TOKEN

router.post(
    '/new', 
    [ // middlewares
        check('name', 'El nombre es obligatorio').not().isEmpty(),
        check('email', 'El email es obligatorio').isEmail(),
        check('password', 'El password debe de ser de 6 caracteres').isLength({ min: 6 }),
        validarCampos
    ],
    crearUsuario 
);

router.post(
    '/',
    [
        check('email', 'El email es obligatorio').isEmail(),
        check('password', 'El password debe de ser de 6 caracteres').isLength({ min: 6 }),
        validarCampos
    ],
    loginUsuario 
);


//para renovar el token
router.get('/renew', validarJWT ,revalidarToken );




module.exports = router;