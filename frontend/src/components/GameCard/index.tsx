import { Game } from "../../types/CustomTypes";

type Props = {
    game: Game;
}

export const GameCard = ({ game }: Props) => {
    return (

        <div>
            <img className="game-card-image" src={game.imageUrl} alt={game.name} />
            <div className="game-card-bottom-container">
                <h2>{game.name}</h2>
                <h2>{game.console?.name}</h2>
                <h2>{game.mediaType}</h2>
                <h2>{game.personalCode}</h2>
            </div>
        </div>

    );
}