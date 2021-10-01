//Desestructuracion
//Asignacion desestructurante


//objeto persona
const persona = {
    nombre: 'tony',
    edad: '45',
    clave: 'Ironman'
}

// extrae lo que pongo dentro de las llaves de mi objeto persona
//const {nombre, edad, clave} = persona;

//console.log(nombre);
//console.log(edad);
//console.log(clave);

const retornaPersona = (usuario)=>{

    const {nombre, edad, clave} = usuario;

    console.log(nombre, edad,clave);
}

retornaPersona(persona);


//Tambien se usa desestructuracion directo en el argumento de la funcion flecha
const retornaPersona2 = ({nombre, edad, clave})=>{

    console.log(nombre, edad,clave);
}

retornaPersona2(persona);


//Tambien se pueden asignar valores por defecto
const retornaPersona3 = ({nombre, edad, clave, rango = 'Capitan'})=>{

    console.log(nombre, edad,clave,rango);
}

retornaPersona3(persona);

 
//useContext
const useContext = ({nombre, edad, clave, rango = 'Capitan'})=>{

    //console.log(nombre, edad,clave,rango);

    return{
        nombreClave: nombre,
        anios: edad,
        latlng: {
            lat: '34,4334',
            lng: '25.9875'
        }
    }
}


//const avenger = useContext(persona);
//Detrucurizando
const {nombreClave,anios,latlng:{lat,lng}} = useContext(persona);


console.log(nombreClave,anios);

console.log(lat,lng);

