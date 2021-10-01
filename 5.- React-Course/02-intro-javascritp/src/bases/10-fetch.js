
//USO DE FETCH


//esto es una apikey
const apiKey = 'tq8YcEeIenjrdWAbsjMJPSand9mNbgOF'

//la funcion fetch retorna una promesa y recibe por argumento la apikey (todo entre backteeks)
const peticionHttp=fetch(`https://api.giphy.com/v1/gifs/random?api_key=${apiKey}`);

// una vez resuelta esta promesa con resolve entonces llamamos al then
peticionHttp.then(resp => resp.json() ) //resp agumento es la informacion que se manda desde el resolve, en este caso obtenemos el json
.then(({data})=>{ // desestructuramos el objeto que se nos envia en el resolve y extraemos solo la data
  const {url} = data.images.original; // del original (pasa por data e images) desestructuramos la url

  const img = document.createElement('img');// creamos un elemento imagen
  img.src=url; // que sacamos de la url (api.giphy.com)

  document.body.append(img); // asignamos al body del index.html

})
.catch(console.warn); // si no se revuelve la promesa(reject en el fetch) del fetch  que devuelva el error, este sirve para todos los then