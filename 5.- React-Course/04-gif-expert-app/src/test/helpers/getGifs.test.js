import { getGifs } from "../../helpers/getGifs"


describe('pruebas con getGis',()=>{


    test('debe retornar 10 elementos ', async() => {
        
        const gifs = await getGifs('One Punch')
        expect(gifs.length).toBe(10)

    })
    


    test('debe retornar arreglo vacio ', async() => {
        
        const gifs = await getGifs('')
        expect(gifs.length).toBe(0)

    })



})