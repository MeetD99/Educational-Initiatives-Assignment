import {Orientation } from './types';
import type { ICommand } from './types';
import { Satellite, CommandExecutionError } from './Satellite';

// --- Command Implementations (Invoker) ---

// 2. Rotate Command
export class RotateCommand implements ICommand {
    constructor(private satellite: Satellite, private direction: Orientation) {}

    execute(): void {
        try {
            this.satellite.rotate(this.direction);
        } catch (error) {
            if (error instanceof CommandExecutionError) {
                console.error(`🛑 Rotation Failed: ${error.message}`);
            } else {
                console.error(`🚨 Unexpected Error during rotation: ${error}`);
            }
        }
    }
}

// 3. Activate Panels Command
export class ActivatePanelsCommand implements ICommand {
    constructor(private satellite: Satellite) {}

    execute(): void {
        this.satellite.activatePanels();
    }
}

// 3. Deactivate Panels Command
export class DeactivatePanelsCommand implements ICommand {
    constructor(private satellite: Satellite) {}

    execute(): void {
        this.satellite.deactivatePanels();
    }
}

// 4. Collect Data Command
export class CollectDataCommand implements ICommand {
    constructor(private satellite: Satellite) {}

    execute(): void {
        try {
            this.satellite.collectData(); // Default 10 units
        } catch (error) {
            // Gold Standard: Logging/Exception Handling
            if (error instanceof CommandExecutionError) {
                console.error(`🛑 Command Failed: ${error.message}`);
            } else {
                console.error(`🚨 An unexpected error occurred: ${error}`);
            }
        }
    }
}

// Special Command for checking status
export class StatusCommand implements ICommand {
    constructor(private satellite: Satellite) {}

    execute(): void {
        const state = this.satellite.getState();
        console.log(`\n--- Current Satellite Status ---`);
        console.log(`📡 Orientation:      ${state.orientation}`);
        console.log(`☀️ Solar Panels:     ${state.solarPanels}`);
        console.log(`💾 Data Collected:   ${state.dataCollected} units`);
        console.log(`--------------------------------\n`);
    }
}
