
//crear peticiones con token y peticiones sin token

const baseUrl = process.env.REACT_APP_API_URL;

const fetchSinToken = ( endpoint, data, method = 'GET' ) => { //endpoint = auth, event, etc, data = lo que queremos enviar

    const url = `${ baseUrl }/${ endpoint }`;  //localhost:4000/api/auth -> ejemplo + el endpoint

    if ( method === 'GET' ) {// si el metodo es exactamente igual a get
        return fetch( url ); // retorna el producto de la peticion fech
    } else { // si el metodo no es get
        return fetch( url, {
            method, //GET
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify( data )// anexamos el body en el cuerpo  que es la data que estamos enviando, lo enviamos como json
        });
    }
}




const fetchConToken = ( endpoint, data, method = 'GET' ) => {

    const url = `${ baseUrl }/${ endpoint }`;
    const token = localStorage.getItem('token') || ''; //extraemos el token

    if ( method === 'GET' ) {
        return fetch( url, {
            method,
            headers: {
                'x-token': token // metemos el token
            }
        });
    } else {
        return fetch( url, {
            method,
            headers: {
                'Content-type': 'application/json',
                'x-token': token
            },
            body: JSON.stringify( data )
        });
    }
}


//exportamos nuestros fetchs
export {
    fetchSinToken,
    fetchConToken
}