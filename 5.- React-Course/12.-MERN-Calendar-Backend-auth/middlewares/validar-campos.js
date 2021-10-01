//middlewaaare para validar campos

const { response } = require('express');
const { validationResult } = require('express-validator');

const validarCampos = (req, res = response, next) => {

    // manejo de errores
    const errors = validationResult( req );
    if ( !errors.isEmpty() ) {
        return res.status(400).json({
            ok: false,
            errors: errors.mapped()
        });
    }

// si el metodo se ejecuta conrrectamente, con next pasa al siguiente middelware
    next();
}

module.exports = {
    validarCampos
}

