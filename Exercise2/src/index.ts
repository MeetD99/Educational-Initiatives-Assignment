// Changed import to use standard CJS-compatible modules
import * as readline from 'readline/promises'; 
import { stdin as input, stdout as output } from 'process';
import { Satellite } from './Satellite'; 
import { 
    ActivatePanelsCommand, 
    CollectDataCommand, 
    DeactivatePanelsCommand, 
    RotateCommand, 
    StatusCommand 
} from './Commands'; 
import { CommandName, Orientation } from './types'; 

// Mapping command strings to expected classes/logic
const COMMAND_MAP: Record<CommandName, (satellite: Satellite, args: string[]) => void> = {
    'rotate': (sat, args) => {
        const direction = args[0] as Orientation | undefined;
        if (!direction || !Object.values(Orientation).includes(direction)) {
            console.error("Usage: rotate <Direction>. Directions: North, South, East, or West.");
            return;
        }
        new RotateCommand(sat, direction).execute();
    },
    'activatepanels': (sat) => new ActivatePanelsCommand(sat).execute(),
    'deactivatepanels': (sat) => new DeactivatePanelsCommand(sat).execute(),
    'collectdata': (sat) => new CollectDataCommand(sat).execute(),
    'status': (sat) => new StatusCommand(sat).execute(),
    'help': () => displayHelp(),
    'exit': () => {
        console.log("Shutting down Satellite Command System. Goodbye!");
        process.exit(0);
    }
};

/**
 * Displays available commands to the user.
 */
function displayHelp(): void {
    console.log(`\n--- Available Commands ---`);
    console.log(`  rotate <Direction>  - Set orientation (North, South, East, West). Example: rotate South`);
    console.log(`  activatePanels      - Turn solar panels ON.`);
    console.log(`  deactivatePanels    - Turn solar panels OFF.`);
    console.log(`  collectData         - Collect 10 units of data (requires active panels).`);
    console.log(`  status              - View the satellite's current state.`);
    console.log(`  help                - Display this help message.`);
    console.log(`  exit                - Quit the application.`);
    console.log(`--------------------------\n`);
}

/**
 * Main function to start the interactive CLI.
 */
async function main() {
    const satellite = new Satellite();
    // Using a simple readline interface compatible with CJS
    const rl = readline.createInterface({ input, output });

    console.log("\n Satellite Command System CLI Started. Type 'help' to see commands.");
    new StatusCommand(satellite).execute();

    // Main interaction loop
    while (true) {
        const inputLine = await rl.question('COMMAND > ');
        
        const trimmedInput = inputLine.trim();

        // Guard against empty input lines
        if (trimmedInput === '') {
            continue; 
        }

        // Clean and parse input: command name and arguments
        const parts = trimmedInput.split(/\s+/);
        
        // Use non-null assertion (!) because the 'if (trimmedInput === '')' check 
        // guarantees that a non-empty string was split, meaning parts[0] is defined.
        const commandName = parts[0]!.toLowerCase() as CommandName;
        const args = parts.slice(1);

        if (commandName === 'exit') {
            rl.close();
            COMMAND_MAP['exit'](satellite, []);
            break; 
        }

        const handler = COMMAND_MAP[commandName];

        if (handler) {
            console.log(`\n[Executing: ${commandName}]`);
            handler(satellite, args);
        } else {
            console.error(`\n Unknown command: '${commandName}'. Type 'help' for a list of commands.`);
        }
    }
}

main();
