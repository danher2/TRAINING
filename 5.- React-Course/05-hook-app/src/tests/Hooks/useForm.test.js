import { renderHook, act } from "@testing-library/react-hooks"
import { useForm } from "../../hooks/useForm"


describe('Pruebas en useForm', () => {

    const initialForm = {

        name: 'daniel',
        email: 'daniel@gmail.com'
    }


    test('Debe regresar un formulario por defecto', () => {

        //contexto
        const { result } = renderHook(() => useForm(initialForm));

        //como useForm devuelve un arreglo desestructuro el arreglo
        const [ values, handleInputChange, reset ] = result.current;

        expect(values).toEqual(initialForm);
        expect(typeof handleInputChange).toBe('function');
        expect(typeof reset).toBe('function');

    });


    test('debe de cambiar el valor del formulario (cambiar name)', () => {

        //contexto
        const { result } = renderHook( () => useForm(initialForm) );

        //como useForm devuelve un arreglo desestructuro el arreglo
        const [ , handleInputChange ] = result.current;

        act(() => {
            handleInputChange({ 
                target: { name: 'name', 
                          value: 'Melissa'
                         } 
                        });
                  });


        const [ values ] = result.current;
        console.log(values);
          
        expect(values).toEqual({ ...initialForm, name: 'Melissa' });
          


    })


    test('Debe de restablecer el formulario con reset ', () => {


         //contexto
         const { result } = renderHook( () => useForm(initialForm) );

         //como useForm devuelve un arreglo desestructuro el arreglo
         const [ , handleInputChange, reset ] = result.current;
 
         act(() => {
             handleInputChange({ 
                 target: { name: 'name', 
                           value: 'Melissa'
                          } 
                         });


                         reset();
                   });
 
 
         const [ values ] = result.current;
         console.log(values);
           
         expect(values).toEqual(initialForm);



    })





})