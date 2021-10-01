import { useEffect, useRef, useState } from "react"

export const useFetch = (url) => {


    const isMounted = useRef(true); // hace referencia al componente que lo tiene
    const [state, setstate] = useState({data: null,loading: true, error: null})


    useEffect(() => { // el use effect es cuando se renderiza el componente
        console.log(isMounted.current)
        return () => {
            isMounted.current = false;
            console.log(isMounted.current)
        }
     
    }, [])

    useEffect(() => {
        
        setstate({data: null,loading: true, error: null});
        // setstate({loading: true});
     
        fetch(url)
        .then(resp=>resp.json())
        .then(data => { 
            
            if (isMounted.current) {
                        
                setstate(
                    {data: data,
                     loading: false,
                     error: null
                    });

                }
                
            })
              .catch(() => {
                  setstate({
                    data: null,
                    loading: false,
                    error: 'No se pudo cargarla info'
                  })
              })  ;

       
    }, [url]);

    return state;



    }
