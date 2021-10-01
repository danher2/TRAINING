import { heroes } from '../data/heroes';

export const getHeroesByPublisher = (publisher) => {

    const validPublisher = ['DC Comics', 'Marvel Comics'];

        // si publisher es falso o sea si no lo encuentra    
        if (!validPublisher.includes(publisher)) {
            
            throw new Error(`Publisher "${ publisher }" no es correcto`);
        }


        return heroes.filter( hero => hero.publisher === publisher );

}
