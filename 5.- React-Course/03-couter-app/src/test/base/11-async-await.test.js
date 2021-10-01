import { getImagen } from "../../base/11-async-await"


describe('Promesa con async-await y fetch',()=>{

    test('debe retornar el url con la imageen', async()=>{

        const url = await getImagen();
       
        // console.log(url);
        expect(url.includes('https://')).toBe(true);

      
    })
})