import * as fs from 'fs';
import * as path from 'path';

type LogLevel = 'INFO' | 'WARN' | 'ERROR' | 'COMMAND';

export class Logger {
	private static instance: Logger | null = null;
	private logFilePath: string;

	private constructor() {
		const logsDir = path.resolve(process.cwd(), 'logs');
		if (!fs.existsSync(logsDir)) {
			fs.mkdirSync(logsDir, { recursive: true });
		}
		this.logFilePath = path.join(logsDir, 'app.log');
	}

	public static getInstance(): Logger {
		if (!Logger.instance) {
			Logger.instance = new Logger();
		}
		return Logger.instance;
	}

	private format(level: LogLevel, message: string, meta?: unknown): string {
		const timestamp = new Date().toISOString();
		const base = `[${timestamp}] [${level}] ${message}`;
		if (meta === undefined) {
			return base;
		}
		let serialized: string;
		try {
			serialized = typeof meta === 'string' ? meta : JSON.stringify(meta);
		} catch {
			serialized = String(meta);
		}
		return `${base} ${serialized}`;
	}

	private write(line: string): void {
		try {
			fs.appendFileSync(this.logFilePath, line + '\n', { encoding: 'utf8' });
		} catch {
			// Fail silently to avoid impacting main logic
		}
	}

	public info(message: string, meta?: unknown): void {
		const line = this.format('INFO', message, meta);
		console.log(line);
		this.write(line);
	}

	public warn(message: string, meta?: unknown): void {
		const line = this.format('WARN', message, meta);
		console.warn(line);
		this.write(line);
	}

	public error(message: string, meta?: unknown): void {
		const line = this.format('ERROR', message, meta);
		console.error(line);
		this.write(line);
	}

	public command(rawInput: string, parsed: { name: string; args: string[] } | null): void {
		const meta = parsed ? { name: parsed.name, args: parsed.args } : { note: 'unparsed' };
		const line = this.format('COMMAND', rawInput, meta);
		console.log(line);
		this.write(line);
	}
}


