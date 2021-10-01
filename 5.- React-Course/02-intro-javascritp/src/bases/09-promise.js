
import {getHeroeById} from "./bases/08-import-export";


//sincrono = que se ejecuta de forma secuencial
//asincrono = que NO ejecuta de forma secuencial

// promesas se crean con un argumento que es un callback
// este callback recibe dos argumentos resolve, reject
const promesa = new Promise((resolve,reject)=>{

//funcion que permite ejecutar una tarea en cierto tiempo y recibe un callback
  setTimeout(()=>{

    const p1= getHeroeById(2);
   resolve(p1);// trasfiere el valor del argumento al then
   reject('No se pudo encontrar el heroe') // transfiere el valor del argumento al catch

  },2000)// el ejecutarse esta funcion primero deben pasar dos seg

});


// en el then y catch tmb recibimos un callback el then depende si se llama el resolve en la promesa y el catch depende si se llama el reject en la promesa
promesa.then((heroe)=>{console.log('heroe', heroe)})// el then ya recibe en su argumento el p1 que le manda el resolve de la promesa
.catch(err=>console.warn(err)); //el catch ya recibe en su argumento lo que le manda de argumento en el reject de la promesa
 

//funcion asincrona que regresa una promesa

const getHeroByIdAsync = (id)=>{

  //esta funcion regresa una promesa
  return new Promise((resolve,reject)=>{

    setTimeout(()=>{
  
      const p1= getHeroeById(id);
      if(p1){ // si esta el personaje (si p1 es true)
        resolve(p1); //manda resolve al then
      }else{ // sino
        reject('No se pudo encontrar el heroe'); // manda el error al catch
      }
    // resolve(p1);
    //  reject('No se pudo encontrar el heroe')
  
    },2000) 

});


}

getHeroByIdAsync(3)
// .then(heroe=>{console.log('heroe', heroe)})
// .catch(error=>console.warn(error))
.then(console.log)
.catch(console.warn);