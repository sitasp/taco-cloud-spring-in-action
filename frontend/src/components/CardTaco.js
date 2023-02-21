import React from 'react';
import cx from 'clsx';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import BrandCardHeader from '@mui-treasury/components/cardHeader/brand';
import TextInfoContent from '@mui-treasury/components/content/textInfo';
import { useN03TextInfoContentStyles } from '@mui-treasury/styles/textInfoContent/n03';
import { useLightTopShadowStyles } from '@mui-treasury/styles/shadow/lightTop';
import { convertLength } from '@mui/material/styles/cssUtils';

import tacoIcon from '../assets/taco.png';

const useStyles = makeStyles(() => ({
    root: {
        maxWidth: 343,
        borderRadius: 20,
    },
    content: {
        padding: 24,
    },
}));

function convert(ingredients) {
    const ingredientsInAnInformalSentence = ingredients.map(item => `${item.name}`).join(', ');
    return ingredientsInAnInformalSentence;
}

export const CardTaco = React.memo(function ProjectCard(props) {
    const styles = useN03TextInfoContentStyles();
    const shadowStyles = useLightTopShadowStyles();
    const cardStyles = useStyles();
    return (
        <div className="single-taco">
            <Card className={cx(cardStyles.root, shadowStyles.root)}>
                <BrandCardHeader
                    image={tacoIcon}
                    extra={'7 minutes'}
                />
                <CardContent className={cardStyles.content}>
                    <TextInfoContent
                        classes={styles}
                        overline={'The'}
                        heading={props.eachTaco.name}
                        body={
                            convert(props.eachTaco.ingredients)
                        }
                    />
                </CardContent>
            </Card>
        </div>
    );
});

export default CardTaco