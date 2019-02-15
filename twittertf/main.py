api = twitter.Api(consumer_key='xxxxx',
                      consumer_secret='yyyyyyy',
                      access_token_key='zzzzzz',
                      access_token_secret='ooooo')


print(api.VerifyCredentials())