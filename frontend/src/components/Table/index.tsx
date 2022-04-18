import { GameRow } from "../Game";
import './custom.css';

export const Table = () => {

    const myGames = [
        {
            id: 1,
            name: 'Dark Souls 2',
            mediaType: 'BluRay',
            personalCode: 'BLUS41045'
        },
        {
            id: 2,
            name: 'Skyrim',
            mediaType: 'BluRay',
            personalCode: 'BLUS31202S'
        },
        {
            id: 3,
            name: 'Call of Duty Black Ops 1',
            mediaType: 'BluRay',
            personalCode: 'BLUS90162'
        },
        {
            id: 4,
            name: 'Call of Duty Black Ops 2',
            mediaType: 'BluRay',
            personalCode: 'BLUS31141'
        }
    ];
    return (
        <table className="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Personal Code</th>
                    <th scope="col">Media Type</th>
                    <th scope="col">Console</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                {myGames.map(game => {
                    return (
                        <GameRow game={game}       
                        />);
                })
                }
            </tbody>
        </table>
    );
}