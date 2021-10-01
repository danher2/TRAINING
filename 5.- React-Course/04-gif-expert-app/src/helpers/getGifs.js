



export const getGifs=async(category)=>{

    const url=`https://api.giphy.com/v1/gifs/search?q=${encodeURI(category)}&limit=10&api_key=RoszfEHy7uvz1ucZchUtBgZbIocCRW5F`;
    const respuesta = await fetch(url); // hace la peticion
    const {data} = await respuesta.json();// extrae el json del objeto respuesta
    const gifs = data.map(img=>{ //img representa cada uno de los elementos en el arreglo data

        return({
            id: img.id,
            title: img.title,
            url: img.images?.downsized_medium.url

        })

    } )

   return gifs;   // esto me devuelve la coleccion de imagenes
}