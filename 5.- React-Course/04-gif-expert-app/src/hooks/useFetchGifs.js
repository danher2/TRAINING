import { useState, useEffect } from "react";
import { getGifs } from '../helpers/getGifs'



export const useFetchGifs = (category) => {


    const [state, setstate] = useState({
        data: [],
        loading: true
    });


    useEffect(() => {
        getGifs(category)
            .then(imgs => {



                setTimeout(() => {
                    setstate({

                        data: imgs,
                        loading: false
                    });
                }, 1500

                );

            });



    }, [category]) //si cambia la categoria lo vuelva a refrescar




    return state;

}
