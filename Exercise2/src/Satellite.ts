import { Orientation, PanelStatus } from './types';
import type { ISatelliteState } from './types';

// Custom error for state-dependent operations (Gold Standard: Exception/Error Handling)
export class CommandExecutionError extends Error {
    constructor(message: string) {
        super(message);
        this.name = "CommandExecutionError";
    }
}

export class Satellite {
    private state: ISatelliteState;

    constructor() {
        // 1. Initialize the Satellite
        this.state = {
            orientation: Orientation.North,
            solarPanels: PanelStatus.Inactive,
            dataCollected: 0,
        };
        console.log("🛰️ Satellite initialized to default state: North, Inactive, 0 Data.");
    }

    public getState(): ISatelliteState {
        // Return a copy to prevent external modification
        return { ...this.state };
    }

    // 2. Rotate
    public rotate(direction: Orientation): void {
        const oldOrientation = this.state.orientation;
        if (!Object.values(Orientation).includes(direction)) {
            throw new CommandExecutionError(`Invalid direction: ${direction}. Must be North, South, East, or West.`);
        }
        this.state.orientation = direction;
        console.log(`➡️ Satellite rotated from ${oldOrientation} to ${direction}.`);
    }

    // 3. Activate Solar Panels
    public activatePanels(): void {
        if (this.state.solarPanels === PanelStatus.Active) {
            console.log("✅ Solar panels already Active.");
            return;
        }
        this.state.solarPanels = PanelStatus.Active;
        console.log("☀️ Solar panels activated.");
    }

    // 3. Deactivate Solar Panels
    public deactivatePanels(): void {
        if (this.state.solarPanels === PanelStatus.Inactive) {
            console.log("🚫 Solar panels already Inactive.");
            return;
        }
        this.state.solarPanels = PanelStatus.Inactive;
        console.log("🌑 Solar panels deactivated.");
    }

    // 4. Collect Data (State-dependent logic)
    public collectData(units: number = 10): void {
        if (this.state.solarPanels !== PanelStatus.Active) {
            // Gold Standard: Exception/Error Handling
            throw new CommandExecutionError(
                "Cannot collect data: Solar panels must be Active to run this operation."
            );
        }
        this.state.dataCollected += units;
        console.log(`📊 Collected ${units} units of data. Total: ${this.state.dataCollected}.`);
    }
}
