


const nombres = 'fernando';
const apellido = 'herrero';
// en vez de concatenar funciones u objetos con + se puede hacer con backtees `${variable}`
const nombreCompleto = 
`${nombres} 
 ${apellido}
 ${1 + 1}
 ` 
 
 // como puedes ver se respetan hasta los saltos de linea
console.log(nombreCompleto);


function getSaludo(nombres){

    return 'Hola mundo '  + nombres;
    }
    
    // podemos concatenar funciones a un string concatenando con backtees de esta forma `${funcion}`
    console.log(`Este es un texto: ${getSaludo(nombres)}`)