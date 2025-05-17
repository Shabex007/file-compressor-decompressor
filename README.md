# File Compressor/Decompressor 🗜️

![Java](https://img.shields.io/badge/Java-17-blue) ![Utility](https://img.shields.io/badge/Type-Utility-success) ![License](https://img.shields.io/badge/License-MIT-green)

A Java-based command-line tool for compressing and decompressing files using GZIP compression.

## Repository Information

- **Name**: java-file-compressor
- **Description**: "A simple yet powerful file compression/decompression tool using GZIP algorithm"

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

1. Run the program
2. Choose an option:

- 1.Compress a file
- 2.Decompress a file

3. Enter the full file path when prompted
4. View operation results

## Technical Implementation

- Uses Java's `GZIPOutputStream` for compression
- Uses Java's `GZIPInputStream` for decompression
- Implements buffered I/O (1024-byte buffer)
- File validation checks:
  - Existence check
  - Directory check
  - Extension validation (.gz for decompression)
- Stream-based processing for memory efficiency
