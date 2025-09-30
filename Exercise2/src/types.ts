// Define the allowed Orientation directions
export enum Orientation {
    North = "North",
    South = "South",
    East = "East",
    West = "West"
}

// Define the Solar Panel status
export enum PanelStatus {
    Active = "Active",
    Inactive = "Inactive"
}

// Interface for the Satellite's current state
export interface ISatelliteState {
    orientation: Orientation;
    solarPanels: PanelStatus;
    dataCollected: number;
}

// Interface for the Command Pattern (Decoupling)
export interface ICommand {
    execute(): void;
    // An optional undo method is included to fulfill the Command Pattern's full potential
    undo?(): void; 
}

// Type definition for valid command names in the CLI
export type CommandName = 'rotate' | 'activatepanels' | 'deactivatepanels' | 'collectdata' | 'status' | 'help' | 'exit';
