

//ASYNC Y AWAIT


//retorna una promesa que solo funciona para el resolve
const getImagenPromesa = () => {
    return new Promise((resolve, reject) => resolve('http://chdsjkdhkjdhkjsf.com'))
}


// async convierte una funcion normal en una promesa (funcionalidad asyncrona) por tanto obtiene los metodos then, catch y finally
// el await siempre va de la mano con el async pero no al reves
// el await es para hacer que podamos trabajar todo el codigo como si fuera sincrono
// la condicion para trabajar con el await  esque debe estar dentro de una funcion async
const getImagen = async() => { // async define que la funcion regresara una promesa

  try{
    const apiKey = 'tq8YcEeIenjrdWAbsjMJPSand9mNbgOF';
    const respuesta= await fetch(`https://api.giphy.com/v1/gifs/random?api_key=${apiKey}`); //como fetch es una promesa y eso es asincrono, await le dice que no pase a la siguiente linea a menos que el fetch se haya cumplido
    const  {data} = await respuesta.json(); // .json tmb devuelve una promesa por lo cual le ponemos otro await para que no pase ala sig line antes que json sea resuelto
  
  
    const {url} = data.images.original; // extrameos la url de original>images>data(el objeto que se manda desde el  resolve del fetch)
    // console.log(url);
    const img = document.createElement('img'); // creamos el elemento de img
    img.src=url; // lo asignamos como src
    document.body.append(img); // lo agregamos al body del html
  
  } catch(error){ // si no se resuelve la promesa mandara un error, lo catchamos y devolvemos el mensaje de error

    console.error(error);
  }

}

// const apiKey = 'tq8YcEeIenjrdWAbsjMJPSand9mNbgOF'

// const peticionHttp=fetch(`https://api.giphy.com/v1/gifs/random?api_key=${apiKey}`);

// peticionHttp
// .then(resp => resp.json() )
// .then(({data})=>{
//   const {url} = data.images.original;

//   const img = document.createElement('img');
//   img.src=url;

//   document.body.append(img);

// })
// .catch(console.warn);
