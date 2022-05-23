import sys

import urllib3

link: str = sys.argv[1]

try:
    http = urllib3.PoolManager()

    request_web = http.request('GET', link)

    request_web.status

except:
    pass
