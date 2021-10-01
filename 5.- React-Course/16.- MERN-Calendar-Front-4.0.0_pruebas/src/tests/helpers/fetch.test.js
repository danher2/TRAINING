
//SIEMPRE QUE SE HAGAN PRUEBAS SE TIENE QUE IMPORTAR EL COMPONENTE QUE SE QUIERE PROBRAR
// PORQUE USAMOS SUS METODOS

import { fetchSinToken, fetchConToken } from '../../helpers/fetch';


describe('Pruebas en el helper Fetch', () => {
    let token = '';


    test('fetchSinToken debe de funcionar', async() => {

        // mandamos la peticion
        const resp = await fetchSinToken('auth', { email: 'daniel@gmail.com', password: '123456' }, 'POST');

        //esperamos que la respuesta sea una instancia de response
        expect( resp instanceof Response ).toBe( true );

        //agarramos el body
        const body = await resp.json();
        
        // esperamos que la respuesta en el body haya salido bien, sea verdad
        expect( body.ok ).toBe( true );

        //obtenemos el token del body
        token = body.token;
        
    })

    test('fetchSinToken debe de funcionar', async() => {

        console.log(token)

        //el token que obtuvimos arrba lo seteamos en el localStorage
        localStorage.setItem('token', token );

        // se manda la peticion
        const resp = await fetchConToken('events/5ee25d21c25cce32af01a3f3', {}, 'DELETE');
       
       //se obtieen el body o el objeto  de la reponse
        const body = await resp.json();

        // esperamos que el mensaje que viene en el body sea el mismo del siguiente
        expect( body.msg ).toBe('Evento no existe por ese id');

        
    })
    

    
})
