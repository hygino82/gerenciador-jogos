export type Console = {
    id: number;
    name: string;
    imageUrl?: string;
}

export type Game = {
    id: number;
    name: string;
    console?: Console;
    personalCode?: string;
    mediaType?: string;
    imageUrl?: string;
}