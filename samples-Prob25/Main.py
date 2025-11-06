import sys
import math
import re

def format_number(num):
    rounded = round(num, 3)
    if abs(rounded - int(rounded)) < 1e-9:
        return str(int(rounded))
    else:
        s = f"{rounded:.3f}"
        s = s.rstrip('0').rstrip('.')
        return s

def main():
    data = sys.stdin.read().strip().splitlines()
    if not data:
        return

    t = int(data[0])
    for i in range(1, t + 1):
        line = data[i].strip()
        if not line:
            continue

        parts = line.split('=')
        if len(parts) < 2:
            continue  
        expr = parts[0].strip()
        given_result_str = parts[1].strip()
        given_val = float(given_result_str)

        expr = expr.replace('^', '**')
        expr = re.sub(r"SQRT\s*\(", "math.sqrt(", expr)

        try:
            computed_val = eval(expr, {"__builtins__": None, "math": math})
        except Exception as e:
            print("Error:", e)
            continue

        computed_rounded = round(computed_val, 3)
        given_rounded = round(given_val, 3)
        if abs(computed_rounded - given_rounded) < 1e-9:
            print("Correct")
        else:
            print(format_number(computed_val))

if __name__ == "__main__":
    main()
