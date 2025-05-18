# File Compressor/Decompressor 🗜️

A Java-based command-line tool for compressing and decompressing files using GZIP compression.

## Features

- 📁 Compress individual files to .gz format
- 📂 Decompress .gz files to their original format
- ✅ Input validation (file existence, extension checks)
- 🚫 Directory handling prevention
- 📊 Progress feedback (success/error messages)
- 🔄 Stream-based processing for memory efficiency

## Supported Operations

1. **Compression**:

   - Takes any file as input
   - Creates a compressed .gz version
   - Preserves original file

2. **Decompression**:
   - Works with .gz files only
   - Restores original filename (removes .gz extension)
   - Preserves compressed file

## How to Use

1. **Run the program**

2. **Choose an option:**:

   - Compress a file
   - Decompress a file

3. **Enter the full file path when prompted**

4. **View operation results**

## Technical Implementation

- Uses Java's `GZIPOutputStream` for compression
- Uses Java's `GZIPInputStream` for decompression
- Implements buffered I/O (1024-byte buffer)
- File validation checks:
  - Existence check
  - Directory check
  - Extension validation (.gz for decompression)
- Stream-based processing for memory efficiency

## Example Output

```bash
------ File Compressor/Decompressor ------
1. Compress a file
2. Decompress a file
Choose an option (1 or 2): 1
Enter the file path to compress: C:\Users\John\Documents\report.txt
✅ File compressed successfully: C:\Users\John\Documents\report.txt.gz
```

```bash
------ File Compressor/Decompressor ------
1. Compress a file
2. Decompress a file
Choose an option (1 or 2): 1
Enter the file path to compress: C:\Users\John\Documents\invalid_file.txt
Error: File does not exist at the given path.
```

```bash
------ File Compressor/Decompressor ------
1. Compress a file
2. Decompress a file
Choose an option (1 or 2): 2
Enter the .gz file path to decompress: C:\Users\John\Documents\report.txt.gz
✅ File decompressed successfully: C:\Users\John\Documents\report.txt
```

```bash
------ File Compressor/Decompressor ------
1. Compress a file
2. Decompress a file
Choose an option (1 or 2): 2
Enter the .gz file path to decompress: C:\Users\John\Documents\data.zip
Error: Only .gz files can be decompressed with this tool.
```

```bash
------ File Compressor/Decompressor ------
1. Compress a file
2. Decompress a file
Choose an option (1 or 2): 3
Invalid choice.
```
