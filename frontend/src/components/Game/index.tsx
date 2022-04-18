import { Game } from "../../types/CustomTypes";

type GameProps = {
    game: Game;
}

export const GameRow = ({game}: GameProps) => {
    return (
        <tr key={game.id}>
            <th scope="row">{game.id}</th>
            <td>{game.name} </td>
            <td>{game.personalCode}</td>
            <td>{game.mediaType}</td>
        </tr>
    );
}