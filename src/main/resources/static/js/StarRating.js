

export default {
    name: 'app',
    components: {
        AwesomeVueStarRating
    },


    data() {
        return {
            star: 5, // default star
            ratingdescription: [
                {
                    text: 'Poor',
                    class: 'star-poor'
                },
                {
                    text: 'Below Average',
                    class: 'star-belowAverage'
                },
                {
                    text: 'Average',
                    class: 'star-average'
                },
                {
                    text: 'Good',
                    class: 'star-good'
                },
                {
                    text: 'Excellent',
                    class: 'star-excellent'
                }
            ],
            hasresults: true,
            hasdescription: true,
            starsize: 'lg', //[xs,lg,1x,2x,3x,4x,5x,6x,7x,8x,9x,10x],
            maxstars: 5,
            disabled: false
        }
    }
}

