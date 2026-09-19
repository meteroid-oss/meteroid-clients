# Scribe — Go backend. For people without a Go toolchain; with one, `go run .` is enough.
#
# The backend depends on the SDK by path (`replace … => ../../../go`), so the build
# context has to be the REPOSITORY ROOT, not this directory:
#
#   docker build -f examples/backends/go/Dockerfile -t scribe-backend-go .
#   docker run --rm -p 8084:8084 --env-file examples/.env scribe-backend-go

FROM golang:1.24 AS build
WORKDIR /src
# Only the two modules the build reads, at the relative paths go.mod expects.
COPY go/ go/
COPY examples/backends/go/ examples/backends/go/
WORKDIR /src/examples/backends/go
# The SDK depends on the standard library only, so there is nothing to download.
RUN CGO_ENABLED=0 go build -trimpath -buildvcs=false -o /scribe-backend-go .

FROM gcr.io/distroless/static-debian12:nonroot
COPY --from=build /scribe-backend-go /scribe-backend-go
EXPOSE 8084
ENTRYPOINT ["/scribe-backend-go"]
