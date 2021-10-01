import { renderHook, act } from "@testing-library/react-hooks"
import { useCounter } from "../../hooks/useCounter"



describe('Pruebas en useCounter', () => {

    test('debe de retornar valores por defecto', () => {
        
        const { result } = renderHook( () => useCounter() );

        console.log(result.current);


        expect(result.current.counter).toBe(10);
        expect(typeof result.current.increment).toBe('function');
        expect(typeof result.current.decrement).toBe('function');
        expect(typeof result.current.reset).toBe('function');

    })
    
    
    
    test('debe de tener el counter en 100', () => {
        
        const { result } = renderHook( () => useCounter(100) );

        console.log(result.current);


        expect(result.current.counter).toBe(100);
       
    })

    test('Debe incrementar el counter en 1', () => {
        
        const { result } = renderHook( () => useCounter(100) );
        //extraemos la funcion increment de result
        const {increment} = result.current;

        //llamamos la funcion incremento dentro de un act()
        //act representa una accion de las funciones que estamos extrayendo
        act(() => {
            increment();
        });

        //probamos que devuelva 101
        const  {counter}  = result.current;
        expect(counter).toBe(101);


    })
    
    
    
    test('Debe decrementar el counter en 1', () => {
        
        const { result } = renderHook( () => useCounter(100) );
        //extraemos la funcion increment de result
        const {decrement} = result.current;

        //llamamos la funcion incremento dentro de un act()
        //act representa una accion de las funciones que estamos extrayendo
        act(() => {
            decrement();
        });

        //probamos que devuelva 101
        const  {counter}  = result.current;
        expect(counter).toBe(99);


    })
    
    
    
    test('Debe resetear el counter  al valor 100', () => {
        
        const { result } = renderHook( () => useCounter(100) );
        //extraemos la funcion increment de result
        const {increment, reset} = result.current;

        //llamamos la funcion incremento dentro de un act()
        //act representa una accion de las funciones que estamos extrayendo
        act(() => {
            increment();
            reset();
        });

        //probamos que devuelva 101
        const  {counter}  = result.current;
        expect(counter).toBe(100);


    })
    



})