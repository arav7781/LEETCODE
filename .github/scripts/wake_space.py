"""GitHub Actions trigger: wake the Space and verify its scheduler completes."""
from datetime import datetime
import json
import time
import urllib.error
import urllib.request
from zoneinfo import ZoneInfo


def main():
    base = "https://aravsaxena884-job-search.hf.space"
    deadline = time.monotonic() + 15 * 60
    expected_day = datetime.now(ZoneInfo("Asia/Kolkata")).date().isoformat()
    while time.monotonic() < deadline:
        try:
            req = urllib.request.Request(base + "/leetcode/health", method="GET")
            with urllib.request.urlopen(req, timeout=60) as response:
                result = json.load(response)
            if result.get("state") == "complete" and result.get("date") == expected_day:
                print("Complete:", result["date"], result["count"], "solutions")
                return
            elif not result.get("configured") or not result.get("scheduler_enabled"):
                raise RuntimeError("Space scheduler is disabled or missing configuration")
            elif result.get("state") == "error":
                raise RuntimeError("Space job failed; inspect the authenticated status endpoint")
        except urllib.error.HTTPError as exc:
            if exc.code in (401, 403):
                raise RuntimeError("Space rejected public health request") from None
            if exc.code == 503:
                print("Space is waking or waiting for configuration")
            else:
                print("Waiting for Space, HTTP", exc.code)
        except (urllib.error.URLError, TimeoutError):
            print("Waiting for Space to start")
        time.sleep(20)
    raise RuntimeError("Space did not complete today's job within 15 minutes")


if __name__ == "__main__":
    main()
